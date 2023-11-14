

Checkstyle (Google) `java -jar checkstyle-*-all.jar -c /google_checks.xml src/ -o report.txt`

Jacoco coverage: `mvn clean verify`

PMD metrics: `mvn clean verify` generates in `target/site/pmd.html`
https://github.com/pmd/pmd/tree/master/pmd-java/src/main/resources/rulesets/java