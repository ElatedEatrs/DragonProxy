/*
 * DragonProxy
 * Copyright (C) 2016-2019 Dragonet Foundation
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You can view the LICENSE file for more details.
 *
 * https://github.com/DragonetMC/DragonProxy
 */
package org.dragonet.proxy.network.translator.java;

import com.github.steveice10.mc.protocol.packet.ingame.server.ServerDifficultyPacket;
import com.nukkitx.protocol.bedrock.packet.SetDifficultyPacket;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.dragonet.proxy.network.session.ProxySession;
import org.dragonet.proxy.network.translator.PacketTranslator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PCDifficultyTranslator implements PacketTranslator<ServerDifficultyPacket> {
    public static final PCDifficultyTranslator INSTANCE = new PCDifficultyTranslator();

    @Override
    public void translate(ProxySession session, ServerDifficultyPacket packet) {
        SetDifficultyPacket bedrockPacket = new SetDifficultyPacket();
        bedrockPacket.setDifficulty(packet.getDifficulty().ordinal());

        session.sendPacket(bedrockPacket);
    }
}
