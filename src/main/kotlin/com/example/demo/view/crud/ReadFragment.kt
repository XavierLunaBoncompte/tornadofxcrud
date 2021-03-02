package com.example.demo.view.crud

import com.example.demo.controller.ClientController
import com.example.demo.model.Client
import javafx.beans.property.SimpleStringProperty
import javafx.scene.Parent
import tornadofx.Fragment
import tornadofx.listview
import tornadofx.onDoubleClick

class ReadFragment : Fragment("READ"){

    private val clientController: ClientController by inject()

    override val root = listview<Client>() {
        items = clientController.clients
        cellFormat {
            text = this.item.telefon
        }
    }
}