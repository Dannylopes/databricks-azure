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
// MAGIC   "fs.azure.account.oauth2.client.id" -> "<application-id>",
// MAGIC   "fs.azure.account.oauth2.client.secret" -> dbutils.secrets.get(scope="<scope-name>",key="<service-credential-key-name>"),
// MAGIC   "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/<directory-id>/oauth2/token")
// MAGIC // Optionally, you can add <directory-name> to the source URI of your mount point.
// MAGIC dbutils.fs.mount(
// MAGIC   source = "abfss://<container-name>@<storage-account-name>.dfs.core.windows.net/",
// MAGIC   mountPoint = "/mnt/<mount-name>",
// MAGIC   extraConfigs = configs)
