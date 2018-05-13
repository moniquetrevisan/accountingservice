Backend -  Comexport Java Code Challenge - V1.0

1. Cadastro de lançamento contábil
post 
  url: http://localhost:8081/api/lancamentos-contabeis/
  body: {"contaContabil":"1111001","data":"20170130","valor":25000.15}
  headers: {
  undefinedaccept: application/json
  accept-encoding: gzip, deflate
  accept-language: en-US,en;q=0.8
  content-type: application/json
  user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36
  }


2. Busca todos os lançamentos
get 
  url: http://localhost:8081/api/lancamentos-contabeis/findAll


3. Busca todos os lançamentos por ID - ! dont forget to escape url characters !
get 
  url: http://localhost:8081/api/lancamentos-contabeis/%5BB@8dcae44


4. Busca todos os lançamentos de uma conta contábil
get 
  url: http://localhost:8081/api/lancamentos-contabeis/?contaContabil=1111001
 

5. Busca stats de todos os dados salvos
get
  url: http://localhost:8081/api/lancamentos-contabeis/_stats


6. Busca stats de uma específica conta contábil
get
  url: http://localhost:8081/api/lancamentos-contabeis/_stats/?contaContabil=1


Testes 
- create
{"contaContabil":"1","data":"20170130","valor":1}
{"contaContabil":"1","data":"20170130","valor":2}
{"contaContabil":"2","data":"20170130","valor":3}
{"contaContabil":"3","data":"20170130","valor":4}

- findAll
url: http://localhost:8081/api/lancamentos-contabeis/findAll
result: 
Request URL: http://localhost:8081/api/lancamentos-contabeis/findAll
Request Method: GET
Status Code: 200 
Remote Address: [::1]:8081
Referrer Policy: no-referrer-when-downgrade
[
{"id":"[B@2d145e06","contaContabil":"1","data":"20170130","valor":1.0},
{"id":"[B@27cbf4ce","contaContabil":"1","data":"20170130","valor":2.0},
{"id":"[B@c350fa","contaContabil":"2","data":"20170130","valor":3.0},
{"id":"[B@41d2949c","contaContabil":"3","data":"20170130","valor":4.0}
]

- findById
url: http://localhost:8081/api/lancamentos-contabeis/%5BB@2d145e06
result:
Request URL: http://localhost:8081/api/lancamentos-contabeis/%5BB@2d145e06
Request Method: GET
Status Code: 200 
Remote Address: [::1]:8081
Referrer Policy: no-referrer-when-downgrade
[
{"id":"[B@2d145e06","contaContabil":"1","data":"20170130","valor":1.0}
]

- findByContaContabil
url: http://localhost:8081/api/lancamentos-contabeis/?contaContabil=1
result:
Request URL: http://localhost:8081/api/lancamentos-contabeis/?contaContabil=1
Request Method: GET
Status Code: 200 
Remote Address: [::1]:8081
Referrer Policy: no-referrer-when-downgrade
[
{"id":"[B@2d145e06","contaContabil":"1","data":"20170130","valor":1.0},{"id":"[B@27cbf4ce","contaContabil":"1","data":"20170130","valor":2.0}
]

- getGeneralStats
url: http://localhost:8081/api/lancamentos-contabeis/_stats
result:
Request URL: http://localhost:8081/api/lancamentos-contabeis/_stats
Request Method: GET
Status Code: 200 
Remote Address: [::1]:8081
Referrer Policy: no-referrer-when-downgrade
[
{"soma":10.0,"min":1.0,"max":4.0,"media":2.5,"qtde":4.0}
]

- getStatsByContaContabil
url: http://localhost:8081/api/lancamentos-contabeis/_stats/?contaContabil=1
result:
Request URL: http://localhost:8081/api/lancamentos-contabeis/_stats/?contaContabil=1
Request Method: GET
Status Code: 200 
Remote Address: [::1]:8081
Referrer Policy: no-referrer-when-downgrade
[
{"soma":3.0,"min":1.0,"max":2.0,"media":0.75,"qtde":2.0}
]
