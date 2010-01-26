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
package org.more.beans.resource.xml;
import org.more.util.attribute.AttBase;
/**
 * 处理XML节点时的节点堆栈，从处理文档开始创建根堆栈往下每一层节点都创建一个新的堆栈（注意：解析属性不创建新的堆栈）。<br/>
 * 通过堆栈可以向父节点传递主要的数据和一些附带数据。
 * @version 2010-1-11
 * @author 赵永春 (zyc@byshell.org)
 */
public class XmlContextStack extends AttBase {
    /**  */
    private static final long serialVersionUID = 4300339262589765696L;
    private String            tagPrefix        = null;                //标签处理堆栈所处理的标签前缀
    private String            tagName          = null;                //标签处理堆栈所处理的标签名
    private XmlContextStack   parent           = null;                //当前堆栈的父级堆栈。
    private String            xpath            = null;                //当前堆栈标签所处的xpath位置。
    /**当前堆栈中保存的重要数据对象。*/
    public Object             context          = null;
    /**如果解析的是属性则该值保存的是属性值否则一直为空。*/
    public String             attValue         = null;
    XmlContextStack(XmlContextStack parent, String tagPrefix, String tagName, String xpath) {
        this.parent = parent;
        this.tagPrefix = tagPrefix;
        this.tagName = tagName;
        this.xpath = xpath;
    };
    /**标签处理堆栈所处理的标签前缀*/
    public String getTagPrefix() {
        return tagPrefix;
    };
    /**标签处理堆栈所处理的标签名*/
    public String getTagName() {
        return tagName;
    };
    /**获取当前堆栈标签所处的xpath位置。*/
    public String getXPath() {
        return this.xpath;
    };
    /**获取当前堆栈的父级堆栈。*/
    public XmlContextStack getParent() {
        return this.parent;
    };
}