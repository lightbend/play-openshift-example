Lightbend Red Hat Certification
===============================

### what is this?

This is a sample app we are creating so Lightbend can become certified on OpenShift Platform.

I've taken Play Hello world app, applied Lightbend Orchestration, and sustituted the base image to "jboss/base-jdk:8" <https://github.com/jboss-dockerfiles/base-jdk>.

### status

Owner: Tooling team / Karl

### notes

```
docker tag 0590c5fe5c9c scan.connect.redhat.com/ospid-27a7763d-9768-4cb2-8f40-48a656332443/play-hello-certification:0.1
docker push scan.connect.redhat.com/ospid-27a7763d-9768-4cb2-8f40-48a656332443/play-hello-certification:0.1
```
