/*
 * Copyright 2011 gitblit.com.
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
package com.gitblit.client;

import java.io.Serializable;
import java.util.Date;

import com.gitblit.utils.StringUtils;

/**
 * Simple class to encapsulate a Gitblit server registration.
 * 
 * @author James Moger
 * 
 */
public class GitblitRegistration implements Serializable, Comparable<GitblitRegistration> {

	private static final long serialVersionUID = 1L;

	String name;
	String url;
	String account;
	char[] password;
	boolean savePassword;
	Date lastLogin;

	public GitblitRegistration(String name, String url, String account, char[] password) {
		this.url = url;
		this.account = account;
		this.password = password;
		this.savePassword = password != null && password.length > 0;
		if (StringUtils.isEmpty(name)) {
			this.name = url.substring(url.indexOf("//") + 2);
		} else {
			this.name = name;
		}
	}

	@Override
	public int compareTo(GitblitRegistration o) {
		return name.toLowerCase().compareTo(o.name.toLowerCase());
	}
}
