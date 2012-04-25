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
package org.more.hypha.context.array;
import org.more.core.event.Event;
import org.more.core.log.Log;
import org.more.core.log.LogFactory;
import org.more.hypha.DefineResource;
import org.more.hypha.context.xml.XmlDefineResource;
/**
 * �����Bean����ʱ���������¼���
 * @version 2010-10-11
 * @author ������ (zyc@byshell.org)
 */
public class ClearDefineEvent extends Event {
    private static Log log = LogFactory.getLog(ClearDefineEvent.class);
    public class ClearDefineEvent_Params extends Event.Params {
        public DefineResource defineResource = null;
    };
    public ClearDefineEvent_Params toParams(Sequence eventSequence) {
        Object[] params = eventSequence.getParams();
        log.debug("Sequence to Params ,params = {%0}", params);
        ClearDefineEvent_Params p = new ClearDefineEvent_Params();
        p.defineResource = (XmlDefineResource) params[0];
        return p;
    }
};