package com.example.demo.controller

import com.example.demo.model.Client
import com.example.demo.utilities.ClientDAO
import tornadofx.*

class ClientController : Controller(){

    val clients = SortedFilteredList(items = getAllClients().observable())

    fun postClient(telefon: String, nom: String, adreca: String, poblacio: String) {
        val client = Client(telefon, nom, adreca, poblacio)
        val dao = ClientDAO()
        dao.addClient(client)
    }

    private fun getAllClients(): List<Client> = ClientDAO().readClient()

    fun putClient(oldClient : Client, newTelefon: String, newNom: String, newAdreca: String, newPoblacio: String) {
        val newClient = Client(newTelefon, newNom, newAdreca, newPoblacio)
        val dao = ClientDAO()
        dao.updateClient(oldClient.telefon, newClient)
        with(clients) {
            remove(oldClient)
            add(newClient)
        }
    }

    fun deleteClients(client: Client) {
        val dao = ClientDAO()
        dao.deleteClient(client.telefon)
        clients.remove(client)
    }
}