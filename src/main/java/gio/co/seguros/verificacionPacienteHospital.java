/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros;

/**
 *
 * @author manu
 */
public class verificacionPacienteHospital {
    
}

/*este coso jalara el paciente id y el hospital del servicio

    Teniendo el ID del paciente, jalara su documentoIdentificacion del getCliente
    teniendo elnumero de hospital, se conectará al hospital a traves de su getPatient (u directo a la DB) y hará la verificación de que si el numeroIdenticiacion del paciente existe

    Si existe, redirige al aggregarC_h.jsp con los respectivos datos

    Si no existe el paciente, envia todos los datos del getCliente al REST para crear pacientes del respectivo hospital.


PROBLEMAS A RESOLVER

-como jalar el documentoIdentificacion de getCliente de un cliente 
-como conectar a un hospital en especifico (tomar en cuenta que hay 3 hospitales en 3 repos distintas
    probablemente usar un "if numHosp = x, que se conecte al path de ese repo en especifico
-como verificar que el paciente esta? probablemente un query de select where ta ta ta
-como enviar los datos obtenidos y almacenados por el pimero paso al addCliente
    -discernir de que datos enviar


*/



