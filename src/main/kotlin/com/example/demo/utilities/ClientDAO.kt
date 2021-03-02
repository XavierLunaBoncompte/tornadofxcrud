package com.example.demo.utilities


import com.example.demo.model.Client
import java.sql.ResultSet
import java.sql.Timestamp

class ClientDAO {
    fun addClient (client: Client) {
        val connection = Database().connection
        val preparedStatement = connection.prepareStatement("INSERT INTO client(telefon, nom, adreca, poblacio) VALUES (?, ?, ?, ?)")
        preparedStatement.setString(1, client.telefon)
        preparedStatement.setString(2, client.nom)
        preparedStatement.setString(3, client.adreca)
        preparedStatement.setString(4, client.poblacio)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        connection.close()
    }

    fun readClient(): List<Client> {
        val connection = Database().connection
        val resultSet = connection.createStatement().executeQuery("SELECT * FROM client")
        val clientList = ArrayList<Client>()
        while (resultSet.next()) {
            val telefon = resultSet.getString("telefon")
            val nom = resultSet.getString("nom")
            val adreca = resultSet.getString("adreca")
            val poblacio = resultSet.getString("poblacio")
            clientList += Client(telefon, nom, adreca, poblacio)
        }
        resultSet.close()
        connection.close()
        return clientList
    }

    fun updateClient(telefon : String, client : Client): Client {
        val connection = Database().connection
        var param = ""
        var param2 = ""
        var param3 = ""
        val paramNom = ", nom = ? "
        val paramAdreca = ", adreca = ? "
        val paramPoblacio = ", poblacio = ? "
        var optinalParamIndexNom = 2
        var optinalParamIndexAdreca = 3
        var optinalParamIndexPoblacio = 4
        if (client.nom.isNotEmpty()) param = paramNom
        if (client.adreca.isNotEmpty()) param2 = paramAdreca
        if (client.poblacio.isNotEmpty()) param3 = paramPoblacio
        val preparedStatement = connection.prepareStatement("UPDATE client set telefon = ? $param $param2 $param3 WHERE telefon = ?")
        preparedStatement.setString(1, client.telefon)
        if (param.isNotEmpty()) {
            preparedStatement.setString(optinalParamIndexNom, client.nom)
            //optinalParamIndexNom = optinalParamIndexNom.inc()
        }
        if (param2.isNotEmpty()) {
            preparedStatement.setString(optinalParamIndexAdreca, client.adreca)
            //optinalParamIndexAdreca = optinalParamIndexAdreca.inc()
        }
        if (param3.isNotEmpty()) {
            preparedStatement.setString(optinalParamIndexPoblacio, client.poblacio)
            optinalParamIndexPoblacio = optinalParamIndexPoblacio.inc()
        }
        preparedStatement.setString(optinalParamIndexPoblacio, telefon)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        connection.close()
        return client
    }

    fun deleteClient(telefon: String) {
        val timestamp = Timestamp(System.currentTimeMillis())
        val connection = Database().connection
        val preparedStatement = connection.prepareStatement("DELETE FROM client WHERE telefon = ?")
        //preparedStatement.setString(1, timestamp.toString())
        preparedStatement.setString(1, telefon)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        connection.close()
    }
}