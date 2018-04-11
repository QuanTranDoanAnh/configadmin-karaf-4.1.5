/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vn.quantda.example.osgi.config.configapp;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

public class Activator implements BundleActivator {

	private static final String CONFIG_PID = "ConfigApp";
	private ServiceRegistration<?> serviceReg;
	private MyApp app;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting bundle");
		Hashtable<String, Object> properties = new Hashtable<String, Object>();
		properties.put(Constants.SERVICE_PID, CONFIG_PID);
		serviceReg = context.registerService(ManagedService.class.getName(), new ConfigUpdater() , properties);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping bundle");
		serviceReg.unregister();
	}

	/**
	 * Updates the configuration in the application. Of course your class can also directly implement ManagedService but this
	 * way you can work with pojos
	 */
	private final class ConfigUpdater implements ManagedService {

		@Override
		public void updated(Dictionary<String, ?> properties) throws ConfigurationException {
			if (properties == null) {
				return;
			}
			if (app == null) {
				app = new MyApp();
			}
			app.setTitle((String)properties.get("title"));
			app.refresh();
			
		}
		
	}

}