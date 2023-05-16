package org.example.repository;

import org.example.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientRepository {
    public List<Client> clients = new ArrayList<>();

    public List<Client> getClients() {
        return clients;
    }

    private void addClient(UUID uuid, String nameClient){
        Client client = new Client(uuid, nameClient);
        clients.add(client);
    }
    private void deletedClient(UUID uuid, String nameClient){
        Client client = new Client(uuid, nameClient);
        clients.remove(client);
    }
}
