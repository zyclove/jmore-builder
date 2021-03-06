package com.whatakitty.jmore.blog.domain.resource;

import com.whatakitty.jmore.framework.ddd.publishedlanguage.AggregateId;

/**
 * resource repository
 *
 * @author WhatAKitty
 * @date 2019/05/27
 * @description
 **/
public interface ResourceRepository {

    /**
     * get the next id for resource
     *
     * @return
     */
    AggregateId<Long> nextId();

    /**
     * add resource into repository
     *
     * @param resource
     */
    void add(Resource resource);

    /**
     * remove the resource from repository
     *
     * @param resource
     */
    void remove(Resource resource);

}
