

Checkstyle (Google) `java -jar checkstyle-*-all.jar -c /google_checks.xml src/ -o report.txt`

Jacoco coverage: `mvn clena verify`

PMD metrics: `mvn clena verify` generates in `target/site/pmd.html`
