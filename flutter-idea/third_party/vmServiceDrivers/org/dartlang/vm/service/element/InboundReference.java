/*
 * Copyright (c) 2015, the Dart project authors.
 *
 * Licensed under the Eclipse Public License v1.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.dartlang.vm.service.element;

// This file is generated by the script: pkg/vm_service/tool/generate.dart in dart-lang/sdk.

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * See getInboundReferences.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class InboundReference extends Element {

  public InboundReference(JsonObject json) {
    super(json);
  }

  /**
   * If `source` is a `List`, `parentField` is the index of the inbound reference. If `source` is a
   * record, `parentField` is the field name of the inbound reference. If `source` is an instance
   * of any other kind, `parentField` is the field containing the inbound reference.
   *
   * Note: In v5.0 of the spec, `@Field` will no longer be a part of this property's type, i.e. the
   * type will become `string|int`.
   *
   * @return one of <code>FieldRef</code>, <code>String</code> or <code>int</code>
   *
   * Can return <code>null</code>.
   */
  public Object getParentField() {
    final JsonElement elem = json.get("parentField");
    if (elem == null) return null;

    if (elem.isJsonPrimitive()) {
    final JsonPrimitive p = (JsonPrimitive) elem;
    if (p.isString()) return p.getAsString();
    if (p.isNumber()) return p.getAsInt();
    }
    if (elem.isJsonObject()) {
    final JsonObject o = (JsonObject) elem;
    if (o.get("type").getAsString().equals("@Field")) return new FieldRef(o);
    }
    return null;
  }

  /**
   * If source is a List, parentListIndex is the index of the inbound reference (deprecated).
   *
   * Note: this property is deprecated and will be replaced by `parentField`.
   *
   * Can return <code>null</code>.
   */
  public int getParentListIndex() {
    return getAsInt("parentListIndex");
  }

  /**
   * The object holding the inbound reference.
   */
  public ObjRef getSource() {
    return new ObjRef((JsonObject) json.get("source"));
  }
}
