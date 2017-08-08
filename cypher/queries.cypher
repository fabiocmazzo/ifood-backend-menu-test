-- Consulta todos buscando pelo code do Node Restaurant e todos os ativos



-- Consulta todos pelo code do node Restaurant, herda o menu do Chain caso o restaurante não tenha e da preferencia pelo o que possui restaurantCode ao invés de chainCode
MATCH (n:Restaurant) WHERE n.code = "RJOAO" WITH n MATCH p=(n)-[*0..]-(m) RETURN p



-- Atualiza para avaiable true todos os relacionamentos HAVE_ITEM_GROUP{available
MATCH (n:ItemGroup)-[r:HAVE_ITEM]-() set r.available = true

-- Atualiza as propriedades de um HAVE_OPTION_GROUP pelo code
MATCH ()-[r:HAVE_OPTION_GROUP{code:"xyz"}]-() SET r.available=true,r. minOptions=3, r.maxOptions=10, r.canRepeat=true, r.order=1 return *