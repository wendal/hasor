/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.platform.security.digest;
import org.platform.security.CodeDigest;
/**
 * �����룬������
 * @version : 2013-4-24
 * @author ������ (zyc@byshell.org)
 */
public final class NoneDigest implements CodeDigest {
    /**����*/
    public String encode(String strValue, String generateKey) {
        return strValue;
    };
    /**����*/
    public String decode(String strValue, String generateKey) {
        return strValue;
    };
}