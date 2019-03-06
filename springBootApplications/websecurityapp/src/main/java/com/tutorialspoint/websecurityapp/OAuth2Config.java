package com.tutorialspoint.websecurityapp;

/* Useful Link


https://github.com/ameizi/spring-boot-oauth2-example/blob/master/OAuth2Server/src/main/java/com/example/OAuth2Configuration.java

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
   private String clientid = "tutorialspoint";
   private String clientSecret = "mypass";
   //private String privateKey = "private key";
   //private String publicKey = "public key";

   @Autowired
   @Qualifier("authenticationManagerBean")
   private AuthenticationManager authenticationManager;

   @Autowired
private PasswordEncoder passwordEncoder;

   /* @Value("classpath:privatekey.p12")
   private Resource privateKeyResource;

   @Value("classpath:publickey.pem")
   private Resource publickeyResource; */
   
   @Bean
   public JwtAccessTokenConverter tokenEnhancer() {
      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
      //converter.setSigningKey(privateKey);
      //converter.setVerifierKey(publicKey);
      KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("keypair.jks"), "mypass".toCharArray());
      converter.setKeyPair(keyStoreKeyFactory.getKeyPair("keypair"));
      return converter;
   }

   /*
            USING KEYPAIR

            @Bean
public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    KeyStoreKeyFactory keyStoreKeyFactory = 
      new KeyStoreKeyFactory(new ClassPathResource("mytest.jks"), "mypass".toCharArray());
    converter.setKeyPair(keyStoreKeyFactory.getKeyPair("mytest"));
    return converter;
}


   */

   /*public key


   / final Resource resource = new ClassPathResource("public.txt");
        // String publicKey = null;
        // try {
        // publicKey = IOUtils.toString(resource.getInputStream(), Charset.defaultCharset());
        // } catch (final IOException e) {
        // throw new RuntimeException(e);
        // }
        // converter.setVerifierKey(publicKey);




   */


   @Bean
   public JwtTokenStore tokenStore() {
      return new JwtTokenStore(tokenEnhancer());
   }
   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
      .accessTokenConverter(tokenEnhancer());
   }
   @Override
   public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
      security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
   }
   @Override
   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients.inMemory().withClient(clientid).secret(passwordEncoder.encode(clientSecret)).scopes("read", "write")
         .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
         .refreshTokenValiditySeconds(20000);

   }
}