Play OpenShift Example
======================

### What is this?

This is a Play example on OpenShift Platform.

### How do I use it?

```
docker pull lightbend-docker-registry.bintray.io/lightbend/play-openshift-example:0.10
docker run -p 9000:9000 lightbend-docker-registry.bintray.io/lightbend/play-openshift-example:0.10 bin/play-openshift-example -Dplay.http.secret.key=changeme1
```

This runs Play on port 9000.

```
[info] play.api.Play - Application started (Prod)
[info] p.c.s.AkkaHttpServer - Listening for HTTP on /0.0.0.0:9000
```

Open http://localhost:9000/ in your browser, and Ctrl + C to quit.

### Status

Owner: Tooling team / Karl
