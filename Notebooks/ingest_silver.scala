// Databricks notebook source
// MAGIC %md
// MAGIC #####Conferir se temos acesso aos dados da camada landing

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados/landing")

// COMMAND ----------

// MAGIC %md
// MAGIC #####Ler dados na Landing e gravar em uma variável

// COMMAND ----------

val path = "dbfs:/mnt/dados/landing/dados_brutos_imoveis.json"
val dados = spark.read.json(path)


// COMMAND ----------

display(dados)

// COMMAND ----------

// MAGIC %md
// MAGIC #####Removendo colunas

// COMMAND ----------

val dados_anuncio = dados.drop("imagens", "usuario")
display(dados_anuncio)

// COMMAND ----------

// MAGIC %md
// MAGIC ##### Criar a coluna de ID, que é um atributo dentro do json

// COMMAND ----------

//o método 'functions' do spark deve ser importado
import org.apache.spark.sql.functions.col

// COMMAND ----------

val df_silver = dados_anuncio.withColumn("id", col("anuncio.id"))
display(df_bronze)

// COMMAND ----------

// MAGIC %md
// MAGIC ##### Salvar os dados na camada Silver em formato Delta

// COMMAND ----------

val path = "dbfs:/mnt/dados/silver/dataset_imoveis" //dataset_imoveis é o nome do arquivo delta que será criado na camada silver
df_silver.write.format("delta").mode(SaveMode.Overwrite).save(path)

// COMMAND ----------

display(df_silver)
