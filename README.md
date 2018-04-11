# Using the config admin service
Using the config admin service

This tutorial will show how to use the config admin service in general as well as the special features Karaf provides for it.
Please also read the tutorial article on my blog:


## Content

- `configapp`: A little application that uses the config admin service to read config and be notified of config changes
- `configapp-blueprint`: The same as above but now using blueprint to abstract away from the details of the config admin service

## Build

Run `mvn clean install`

## Installation

There is only an automated installation for the blueprint case.

feature:repo-add mvn:net.lr.tutorial.configadmin/configadmin-features/1.0/xml
feature:install  tutorial-configadmin