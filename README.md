# CORREIOS INTEGRATION
sample API integration with correios 


# Swagger link 
http://localhost:8080/swagger-ui.html#!/




# JSON OF RETURN

{
  "neighborhood": "Canindé",
  "cep": "03034000",
  "city": "São Paulo",
  "complement": "",
  "address": "Rua Araguaia",
  "uf": "SP"
}



# HOW TO IMPORT WSDL
run this command in a past that your preference </br>

<p>wsimport -keep -verbose  https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl </p>