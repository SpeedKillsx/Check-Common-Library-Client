Introduction
-------------
`check-common-lib` est une librairie utilitaire Spring Boot contenant des outils transverses :
- Audit automatique
- Log de temps dexécution
- Mécanisme de Retry simple par annotation
  Installation Maven
-------------------
```xml
<dependency>
  <groupId>io.github.speedkillsx</groupId>
  <artifactId>checkcommonlib</artifactId>
  <version>0.0.8</version>
</dependency>
```

Configuration
--------------
```yaml
check-common:
    audit-enabled: true
    log-execution-time: true
    retry:
        enabled: true
        default-max-attempts: 3
        default-delay-ms: 500
```
Utilisation
------------
```java
@RetryOnFailure(maxAttempts = 3, delayMs = 200, include = {IOException.class})
public void processPaiement() {
// traitement instable
}
```
Résultat attendu
-----------------
```CMD
[AUDIT] Appel de : processPaiement()
[EXECUTION TIME] Méthode exécutée en 221 ms
```