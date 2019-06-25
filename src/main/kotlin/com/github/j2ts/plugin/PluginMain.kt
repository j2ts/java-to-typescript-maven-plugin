package com.github.j2ts.plugin

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name="sayhi")
class PluginMain  : AbstractMojo() {
    override fun execute() {
        log.info("Hello!")
    }
}
