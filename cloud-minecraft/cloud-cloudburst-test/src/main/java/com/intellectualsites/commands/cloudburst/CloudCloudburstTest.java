//
// MIT License
//
// Copyright (c) 2020 Alexander Söderberg
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
package com.intellectualsites.commands.cloudburst;

import com.intellectualsites.commands.annotations.AnnotationParser;
import com.intellectualsites.commands.annotations.Argument;
import com.intellectualsites.commands.annotations.CommandMethod;
import com.intellectualsites.commands.annotations.specifier.Range;
import com.intellectualsites.commands.execution.CommandExecutionCoordinator;
import com.intellectualsites.commands.meta.SimpleCommandMeta;
import org.cloudburstmc.server.command.CommandSender;
import org.cloudburstmc.server.plugin.PluginBase;
import org.cloudburstmc.server.utils.TextFormat;

import javax.annotation.Nonnull;
import java.util.function.Function;

/**
 * Cloudburst test plugin
 */
public final class CloudCloudburstTest extends PluginBase {

    @Override
    public void onLoad() {
        setEnabled(true);
    }

    @Override
    public void onEnable() {
        final CloudburstCommandManager<CommandSender> cloudburstCommandManager = new CloudburstCommandManager<>(
                this,
                CommandExecutionCoordinator.simpleCoordinator(),
                Function.identity(),
                Function.identity()
        );
        final AnnotationParser<CommandSender> annotationParser = new AnnotationParser<>(cloudburstCommandManager,
                                                                                        CommandSender.class,
                                                                                        p -> SimpleCommandMeta.empty());
        annotationParser.parse(this);
    }

    @CommandMethod("test <num> [str]")
    private void testCommand(@Nonnull @Argument(value = "str", defaultValue = "potato") final String string,
                             @Nonnull final CommandSender source,
                             @Argument("num") @Range(min = "10", max = "33") final int num) {
        source.sendMessage(TextFormat.RED + "You said: "
                           + TextFormat.GOLD + string
                           + TextFormat.RED + " & "
                           + TextFormat.GOLD + num);
    }

}
