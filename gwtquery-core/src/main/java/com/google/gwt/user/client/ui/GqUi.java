/*
 * Copyright 2011, The gwtquery team.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.user.client.ui;

import static com.google.gwt.query.client.GQuery.$;

import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;

import java.util.Iterator;

/**
 * GQuery Utility class to access protected methods in ui package.
 */
public class GqUi {

  public static void attachWidget(Widget widget) {
    if (widget != null && widget.getParent() == null) {

      Widget parentWidget = getFirstParentWidget(widget);

      if (parentWidget == null) {
        RootPanel.detachOnWindowClose(widget);
        widget.onAttach();
      } else if (parentWidget instanceof HTMLPanel) {
        ((HTMLPanel) parentWidget).add(widget,
            widget.getElement().getParentElement());
      } else {
        throw new RuntimeException(
            "No HTMLPanel available to attach the widget.");
      }
    }
  }

  public static void detachWidget(final Widget widget) {
    if (widget != null) {
      widget.removeFromParent();
    }
  }

  private static Widget getFirstParentWidget(Widget w) {
    Element e = w.getElement().getParentElement();
    BodyElement body = Document.get().getBody();
    while ((e != null) && (body != e)) {
      if (Event.getEventListener(e) != null) {
        Widget p = $(e).widget();
        if (p != null){
          return p;
        }
      }
      e = e.getParentElement();
    }
    return null;
  }

  /**
   * This method detach a widget of its parent without do a physical detach (DOM
   * manipulation)
   * 
   * @param w
   */
  public static void doLogicalDetachFromHtmlPanel(Widget w) {
    Widget parent = w.getParent();
    
    if (parent instanceof HTMLPanel) {
      ((HTMLPanel) parent).getChildren().remove(w);
      w.setParent(null);
      
    } else{
      throw new IllegalStateException(
          "You can only use this method to detach a child from an HTMLPanel");
    }
   

  }
  
  public static Iterator<Widget> getChildren(Widget w){
    if(w instanceof Panel){
      return ((Panel)w).iterator();
    }
    if(w instanceof Composite){
      return getChildren(((Composite)w).getWidget());
    }
    
    return null;
  }
}