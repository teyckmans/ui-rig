# UiRig

## Introduction
I read about [elm](http://elm-lang.org/) and I think the idea is great. But I did not like the ports that are needed
to interop with JavaScript. I wanted to try out Kotlin and I knew it also compiles to JavaScript and has good interop
so off I went into Kotlin land. 

After 3 weeks of sporadic evening coding something emerged that was already working rather decently. 
It had a [VirtualDOM](https://github.com/snabbdom/snabbdom) and command support for a REST call. 
It even behaved in a stable fashion.
 
## Examples
In the [examples repository](https://github.com/teyckmans/ui-rig-examples) there is currently one example called [demo](https://github.com/teyckmans/ui-rig-examples/tree/master/demo).
The demo application shows how to use this library.

## State
Currently this library is really in an alpha state, so please forgive me for the rough edges at the moment.
If you give this framework a try, feedback is really appreciated.

### HTML element support
Not all HTML elements/attributes are supported in the DSL around snabbdom.

I've foreseen the following generic methods to compensate for this. 
* `DslBodyTag.tag(name : String, vararg cssClasses : String, init : DslBodyTag.() -> Unit)`
* `DslTag.attr(name : String, value: String)`

### Event Handler support
* There is only support 'oninput' for text and password fields.
* There is only support 'onclick' for buttons and links. 

I have not foreseen a generic method to handle other events. This is a priority for the next version.

### VirtualDOM
UiRig uses [snabbdom](https://github.com/snabbdom/snabbdom) version 0.7.2. 


### HTTP request handling
The HttpCommand is a very basic wrapper around the XMLHttpRequest.

I'm thinking about creating a DSL to describe HTTP request handling. 

Shared settings and command behaviour will be captured in an HttpCommandFactory.

```kotlin

val httpCommandFactory = httpCommandFactory {
  header(name, value) // think of Authorization headers that need to be set for all but the login request
  
  options {
    requestTimeOut = 1000
    // other options
  }
  
  error {
    // message creation logic here
  }
  
  timeOut {
    // message creation logic here
  }
}

```

Actual commands are created by using the get/post/... methods that expose a DSL to define request specific settings and behaviour.

```kotlin
val httpCommand = httpCommandFactory.post {
  header (name, value)

  options {
    requestTimeOut = 2000
    // other options
  }

  body(bodyValue, serializer)
  
  ok {
    // message creation logic here
  }
  
  ok(serializer) // to just parse the response with - if the response maps to a message
  ok(serializer) {
    // message creator method reference that wraps the parsed response
  }
  
  error {
    // message creation logic here
  }
  
  timeOut {
    // message creation logic here
  }
}

```

The above code is just an idea, no promises made here.

## Why

I am mostly a Java backend guy (14 years and counting). 
I do want to do frontend work but I have not encountered any frontend UI framework that I like. 
I find that most frameworks are just a port of MVC server side rendering copied into web browser land.
Usually things don't behave as expected for me and it's hard to predict in what order things happen. This is not acceptable for me. It costs way to much time to get things to work in a stable fashion.
