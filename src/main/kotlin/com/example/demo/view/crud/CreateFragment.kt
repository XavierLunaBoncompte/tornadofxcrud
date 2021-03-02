package com.example.demo.view.crud

import com.example.demo.controller.ClientController
import com.example.demo.utilities.PopupDialog
import javafx.beans.property.SimpleStringProperty
import javafx.scene.Parent
import javafx.stage.StageStyle
import tornadofx.*

class CreateFragment : Fragment ("CREATE"){
    private val telefonString = SimpleStringProperty()
    private val nomString = SimpleStringProperty()
    private val adrecaString = SimpleStringProperty()
    private val poblacioString = SimpleStringProperty()

    private val clientController: ClientController by inject()

    override val root = vbox {
        form {
            fieldset {
                field("Telefon")
                textfield(telefonString)
                field("Nom")
                textfield(nomString)
                field("Adreça")
                textfield(adrecaString)
                field("Poblacio")
                textfield(poblacioString)
            }
            button("Crear client") {
                action {
                    clientController.postClient(telefonString.value, nomString.value, adrecaString.value, poblacioString.value)
                    telefonString.value = ""; nomString.value = ""; adrecaString.value = ""; poblacioString.value = ""
                    find<PopupDialog>(params = mapOf("message" to "New Client Added")).openModal(stageStyle = StageStyle.UTILITY)
                }
            }
        }

    }
}