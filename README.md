# RigelDev-UI

## Why

I am most likely just another dumb guy thinking he is so smart...

But just in case I'm wrong and I do fill some kind of gap out there. Here is my take on a frontend UI framework.

I am mostly a Java backend guy (14 years and counting). 
I do want to do frontend work but I don't find any frontend UI framework 
that I like where I have some kind of a click with.
 
## Basis

I read about [elm](http://elm-lang.org/) and I think the idea is great. But I did not like the ports that are needed
to interop with JavaScript. I wanted to try out Kotlin and I knew it also compiles to JavaScript and has good interop
so off I went into Kotlin land. 

After 3 weeks of sporadic evening coding something emerged that was already working rather decently. 
It had a [VirtualDOM](https://github.com/snabbdom/snabbdom) and command support for a REST call. 
It even behaved in a stable fashion.
 
 
## Example

In the examples directory of this repository there is currently one example called demo.
The demo application show how to use this library.

## State

Currently this library is really in a pre-alpha state, so please forgive me for the rough edges at the moment.

* Not all HTML elements are supported in the DSL around snabbdom.
* There is only support 'oninput' for text and password fields.
* There is only support 'onclick' for buttons. 
* We don't use the latest version of snabbdom. 
* The HttpCommand is a very basic wrapper around XMLHttpRequest.