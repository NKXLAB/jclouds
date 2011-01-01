/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.jclouds.loadbalancer.domain;

import java.util.Set;

import org.jclouds.domain.ResourceMetadata;
import org.jclouds.loadbalancer.domain.internal.LoadBalancerMetadataImpl;

import com.google.inject.ImplementedBy;

/**
 * @author Adrian Cole
 */
@ImplementedBy(LoadBalancerMetadataImpl.class)
public interface LoadBalancerMetadata extends ResourceMetadata<LoadBalancerType> {
   /**
    * Type of the resource, ex node, image, size
    * 
    */
   @Override
   LoadBalancerType getType();

   /**
    * id of the server within the naming scope it was created. potentially generated by the service.
    * 
    */
   @Override
   String getProviderId();

   /**
    * user defined name of the server.
    * 
    */
   @Override
   String getName();

   /**
    * 
    * A means to uniquely address this resource within a provider. For example, if the namespace of
    * a node or image is region based, the id will likely include both the region and the
    * provider-supplied id encoded to avoid collisions.
    * 
    */
   String getId();

   /**
    * @return DNS Name of the load balancer; note we don't use InetAddress, as it is incompatible
    *         with google appengine.
    */
   // TODO: this is no longer the case
   Set<String> getAddresses();

}
