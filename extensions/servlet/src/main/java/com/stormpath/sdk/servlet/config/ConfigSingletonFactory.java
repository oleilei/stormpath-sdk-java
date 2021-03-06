/*
 * Copyright 2015 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.servlet.config;

import com.stormpath.sdk.lang.Assert;
import com.stormpath.sdk.servlet.util.ServletContextInitializable;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 *
 * @param <T> The type of the singleton object returned
 *
 * @since 1.0.RC3
 */
public abstract class ConfigSingletonFactory<T> implements ServletContextInitializable, Factory<T> {

    private T instance;
    private ServletContext servletContext;

    @Override
    public T getInstance() {
        Assert.notNull(this.instance, "Factory must be initialized before it can be used.");
        return this.instance;
    }

    protected Config getConfig() {
        Assert.notNull(this.servletContext, "init must be called first before config can be obtained.");
        return ConfigResolver.INSTANCE.getConfig(this.servletContext);
    }

    protected abstract T createInstance(ServletContext servletContext) throws Exception;

    @Override
    public void init(ServletContext servletContext) throws ServletException {
        this.servletContext = servletContext;
        T instance;
        try {
            instance = createInstance(servletContext);
            Assert.notNull(instance, "Factory instance cannot be null.");
            this.instance = instance;
        } catch (Exception e) {
            String msg = "Unable to create singleton instance: " + e;
            throw new ServletException(msg, e);
        }
    }
}
