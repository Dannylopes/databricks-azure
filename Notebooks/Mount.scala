// Databricks notebook source
dbutils.fs.mkdirs("/mnt/dados")

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt")

// COMMAND ----------

// MAGIC %scala
// MAGIC val configs = Map(
// MAGIC   "fs.azure.account.auth.type" -> "OAuth",
// MAGIC   "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
// MAGIC   "fs.azure.account.oauth2.client.id" -> "b866f361-507b-42a6-b65d-f91ad89d5b1b",
// MAGIC   "fs.azure.account.oauth2.client.secret" -> "A4v8Q~u2kLmfAcZzNDJDUh5rUpOn2Ev8oNJDUcce",
// MAGIC   "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/46505875-a4f1-4a13-a17e-cb57668837ba/oauth2/token")
// MAGIC // Optionally, you can add <directory-name> to the source URI of your mount point.
// MAGIC dbutils.fs.mount(
// MAGIC   source = "abfss://imoveis@stackatomstorageaccount.dfs.core.windows.net/",
// MAGIC   mountPoint = "/mnt/dados",
// MAGIC   extraConfigs = configs)

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados")
