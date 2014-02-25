twitch-plays-client
================================

### Description

Based on [TwitchPlaysPokemon](http://www.twitch.tv/twitchplayspokemon), this is an example Java/Groovy client application
to work alongside the server application in this repository: [twitch-plays-server](https://github.com/greymeister/twitch-plays-server).

### Usage

Run <code>gradlew installApp</code> To build the application.  Then run the following:

    ./build/install/twitch-plays-client/bin/twitch-plays-client

You should see a popup window which will log the commands you receive from IRC.

### Configuration

When you build the application, a file underneath <code>build/install/twitch-plays-client/lib</code> will be created named
<code>override.properties</code>.  You need to put the appropriate settings for your RabbitMQ server that correspond
with your settings on the server side.
