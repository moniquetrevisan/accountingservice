Backend -  Comexport Java Code Challenge - V1.0

1. Cadastro de lançamento contábil
post {
  url: http://localhost:8081/api/lancamentos-contabeis/
  body: {"contaContabil":"1111001","data":"20170130","valor":25000.15}
  headers: {
  undefinedaccept: application/json
  accept-encoding: gzip, deflate
  accept-language: en-US,en;q=0.8
  content-type: application/json
  user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36
  }
}

2. Busca todos os lançamentos
-- findAll
get {
  url: http://localhost:8081/api/lancamentos-contabeis/findAll
}

3. Busca todos os lançamentos por ID
-- findById - ! dont forget to escape url characters !
get {
  url: http://localhost:8081/api/lancamentos-contabeis/%5BB@8dcae44
}

4. Busca todos os lançamentos por conta contábil
-- findByContaContabil
get {
  url: http://localhost:8081/api/lancamentos-contabeis/?contaContabil=1111001
}