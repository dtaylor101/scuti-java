package com.scuti.messages.outgoing.navigator;

import com.scuti.Emulator;
import com.scuti.messages.outgoing.Outgoing;
import com.scuti.messages.outgoing.OutgoingMessage;
import com.scuti.rooms.Room;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class NavigatorRoomMessage extends OutgoingMessage {
    @Override
    public void compose() throws IOException {

        HashMap<Integer, Room> rooms = Emulator.scuti().getRoomManager().getRoomsLoaded();
        JSONObject roomsPacket = new JSONObject();
        JSONObject data = new JSONObject();

        roomsPacket.put("packetId", Outgoing.RoomNavigatorListMessage);

        for(Room room : rooms.values()) {
            JSONObject roomData = new JSONObject();

            // owner id -> owner name
            roomData.put("owner", room.getOwnerId());
            roomData.put("description", room.getDescription());

            data.put(room.getName(), roomData);
        }

        roomsPacket.put("data", data);
        this.client.getRemote().sendString(roomsPacket.toString());
    }
}
