/*
 * Copyright 2014 Stormpath, Inc.
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
package com.stormpath.sdk.provider;

/**
 * Google's specific {@link ProviderAccountRequestBuilder} interface.
 *
 * @since 1.0.beta
 */
public interface GoogleCreateProviderRequestBuilder extends CreateProviderRequestBuilder<GoogleCreateProviderRequestBuilder> {

    /**
     * Setter for the redirection Uri for your Google Application.
     *
     * @param redirectUri the redirection Uri for your Google Application.
     * @return the builder instance for method chaining.
     */
    GoogleCreateProviderRequestBuilder setRedirectUri(String redirectUri);

}