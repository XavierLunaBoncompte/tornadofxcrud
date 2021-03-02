package com.example.demo.view.crud

import com.example.demo.controller.ClientController
import com.example.demo.model.Client
import com.example.demo.utilities.PopupDialog
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.Parent
import javafx.stage.StageStyle
import tornadofx.*

class UpdateFragment : Fragment("UPDATE") {
    private val comboBoxObject = SimpleObjectProperty<Client>()
    private val newTelefonString = SimpleStringProperty()
    private val newNomString = SimpleStringProperty()
    private val newAdrecaString = SimpleStringProperty()
    private val newPoblacioString = SimpleStringProperty()
    private val clientController: ClientController by inject()
    override val root = vbox {
        form {
            combobox<Client> (comboBoxObject){
                items = clientController.clients
                cellFormat {
                    text = this.item.telefon
                }

            }
            fieldset {
                field("New Telefon")
                textfield(newTelefonString)
                field("New Nom")
                textfield(newNomString)
                field("New Adreça")
                textfield(newAdrecaString)
                field("New Poblacio")
                textfield(newPoblacioString)
            }
            button("Actualitzar client") {
                action {
                    clientController.putClient(
                            comboBoxObject.get(),
                            newTelefonString.value,
                            newNomString.valueSafe,
                            newAdrecaString.valueSafe,
                            newPoblacioString.valueSafe
                    )

                    newTelefonString.value = "";  newNomString.value = ""; newAdrecaString.value = ""; newPoblacioString.value = ""
                    comboBoxObject.value = null
                    find<PopupDialog> (mapOf("message" to "Client actualitzat")).openModal(stageStyle = StageStyle.UTILITY)
                }
            }
        }
    }
}