

**IMPORTANT:  GwtQuery has been moved to github, please report issues, ask request features or contribute to code there: http://github.com/gwtquery**


## Introduction ##

GwtQuery a.k.a. GQuery is a jQuery-like API written in GWT, which allows GWT to be used in progressive enhancement scenarios where perhaps GWT widgets are too heavyweight.

It can also be used to complement your normal GWT development giving you powerful tools which are not present in GWT-core: find and enhance your GWT widgets, promote dom elements to widgets, decouple UI parts, useful methods to access js functions and properties without writing jsni, Promises and much more.

GwtQuery is easy to learn for those using jQuery as they share the same api, aditionally gquery adds nice features like type-safe css, compile time optimisations, etc.

Currently, almost the jQuery API is written and all CSS3 selectors should be supported. If you found anything unsupported or not implemented yet, please open an [issue](http://code.google.com/p/gwtquery/issues/list).


## GwtQuery in action ##
  * Enhance existing html by adding some nice effects using a syntax almost identical to jQuery:
```
import static com.google.gwt.query.client.GQuery.*;
import com.google.gwt.query.client.Function;

public void onModuleLoad() {
  //Hide the text and set the width and append an h1 element
  $("#text").hide()
    .css("width", "400px")
    .prepend("<h1>GwtQuery Rocks !</h1>");
    
    //add a click handler on the button
    $("button").click(new Function(){
      public void f() {
        //display the text with effects and animate its background color
        $("#text").as(Effects)
          .clipDown()
          .animate("backgroundColor: 'yellow'", 500)
          .delay(1000)
          .animate("backgroundColor: '#fff'", 1500);
      }
    });
}
```

<a href='Hidden comment: 
* Because gQuery is java, you can take advance of gquery type-safe methods and  let the compiler to warn you about incorrect syntax replacing the line above by:
```
   .css(CSS.WIDTH.with(Length.px(400)))
```
'></a>

  * Watch this code in action in this [page](http://gwtquery.googlecode.com/svn/trunk/demos/HomePageSample/HomePageSample.html)

## Documentation ##
If you want to learn more about what GwtQuery is, please read
  * The [getting started guide](http://code.google.com/p/gwtquery/wiki/GettingStarted)
  * The [gQuery recent talk](http://slides.gquery.org/gwtcreate) of Manolo and Julien at the GWT.create 2013 event in San Francisco and Frankfurt demonstrating new cool features in gQuery.
  * The [slides ](http://www.slideshare.net/dodotis/gquery-a-jquery-clone-for-gwt-rivieradev-2011) of Manolo's presentation at the Riviera-dev 2011 conferences in France.
  * Ray's [presentation ](http://www.google.com/events/io/2009/sessions/ProgressivelyEnhanceAjaxApps.html) at GoogleIO 2009.
## Plugins ##
GwtQuery supports a [plugin system](http://code.google.com/p/gwtquery/wiki/WritingPlugins) for extension of the core. Take a look to the [gwt-query-plugin site](http://code.google.com/p/gwtquery-plugins/) to get them or to commit a new one.

Contributions welcomed!

- The GwtQuery Team