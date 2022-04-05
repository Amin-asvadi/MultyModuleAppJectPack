# Jetpack Compose sample app
This is a modular sample Jetpack Compose project
                    +----------+
          +-------------------+   app    +--------------------+
          |                   +----+-----+                    |
          |                        |                          |
          |                        |                          |
    +-----v-----+             +----v-----+               +----v-----+
    | resources <-------------+ features +--------------->   core   |
    +-----------+             +----+-----+               +----^-----+
                                   |                          |
                              +----v-----+                    |
                              |  domain  +---+----------------+
                              +----+-----+   |
                                   |         |
                              +----v-----+   |
                              |repository|   |
                              +----+-----+   |
                                   |         |
                              +----v-----+   |
                              |  network <---+
                              +----------+


The technologies and libraries that I used in this project are :

Jetpack Compose, Navigation Components.

DDD(Domain Driven Design) software design,

MVVM architecture,

Dagger & Hilt,

Retrofit & Gson,

