package com.test.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {
    // You can change load balancing algorithm rule at here
    @Bean
    public IRule rule(){
        // return new RetryRule();
        // return new WeightedResponseTimeRule();
        // return new BestAvailableRule();
        return new RoundRobinRule();
    }
}
