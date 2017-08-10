# iFood Backend Test - Menu

The frameworks chosen were basically:
 
  * SpringBoot 1.5.x;
  * SpringMVC Rest;
  * Spring Data Neo4J (Baseado no Neo4J-OGM)
  
## Data Model

 The chosen database was the Neo4J, mainly for working with graphs and with the advantage of Neo4J persisting the data
   Natively in graphs, which greatly improves performance. Besides having excellent documentation.
  
   Basically, the data was represented as :
  
  ![modelo de dados](https://github.com/fabiocmazzo/ifood-backend-menu-test/raw/master/documents/Ifood%20Menu%20Model.jpg)
 
## Cache

Querying graphs in Neo4J is not expensive If the query is written efficiently and also Neo4J is scalable, but since there is a transformation (by MenuAdapter) after the return of Neo4J, I chose to cache the result already transformed and ready to be serialized by Jackson on a Redis base. The TTL(Time to Live) is configurable, but it does not have to be too low, a long TTL and with a logic of invalidating the cache in case of changes in the data of a particular Restaurant or Chain works well and considerably reduces access to the Neo4J. Most cloud vendors already provide Redis-based products such as the AWS Elastic Cache for Redis, which makes the solution scalable and cost effective.
  
  
