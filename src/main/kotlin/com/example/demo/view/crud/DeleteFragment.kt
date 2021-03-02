package com.example.demo.view.crud

import com.example.demo.controller.ClientController
import com.example.demo.model.Client
import com.example.demo.utilities.PopupDialog
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.Parent
import javafx.stage.StageStyle
import tornadofx.*

class DeleteFragment : Fragment("DELETE") {
    private val comboBoxObject = SimpleObjectProperty<Client>()
    private val clientController: ClientController by inject()
    override val root = vbox {
        form {
            combobox<Client>(comboBoxObject) {
                items = clientController.clients
                cellFormat {
                    text = this.item.telefon
                }
            }
            button("Delete") {
                action {
                    clientController.deleteClients(comboBoxObject.get())
                    comboBoxObject.value = null
                    find<PopupDialog>(mapOf("message" to "Client eliminat")).openModal(stageStyle = StageStyle.UTILITY)
                }

            }
        }

    }
}