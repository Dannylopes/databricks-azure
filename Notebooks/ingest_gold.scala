// Databricks notebook source
// MAGIC %md
// MAGIC #####Conferir se temos acesso aos dados da camada landing

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados/silver")

// COMMAND ----------

// MAGIC %md
// MAGIC #####Ler dados na silver e gravar em uma variável

// COMMAND ----------

val path = "dbfs:/mnt/dados/silver/dataset_imoveis"
val df = spark.read.format("delta").load(path)


// COMMAND ----------

display(df)

// COMMAND ----------

// MAGIC %md
// MAGIC #####Transformando campo do json em colunas

// COMMAND ----------

// a variável df possui dois atributos: 'anuncio' e 'id'
// o comando abaixo extrai todas as colunas do atributo 'anuncio' para colunas distintas
display(df.select("anuncio.*"))

// COMMAND ----------

// a coluna 'endereco' possui colunas aninhadas e precisamos extraí-las.
display(df.select("anuncio.*", "anuncio.endereco.*"))

// COMMAND ----------

val dados_detalhados = df.select("anuncio.*", "anuncio.endereco.*")

// COMMAND ----------

display(dados_detalhados)

// COMMAND ----------

// MAGIC %md
// MAGIC ##### Remover colunas

// COMMAND ----------

val df_gold = dados_detalhados.drop("caracteristicas", "endereco")
display(df_gold)

// COMMAND ----------

display(df_gold)

// COMMAND ----------

// MAGIC %md
// MAGIC ##### Salvar os dados na camada Gold em formato Delta

// COMMAND ----------

val path = "dbfs:/mnt/dados/gold/dataset_imoveis" 
df_gold.write.format("delta").mode("overwrite").save(path)
