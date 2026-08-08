plugins{
    kotlin("jvm") version "2.3.0"
}

repositories{
    mavenCentral()
}

dependencies{
    implementation(kotlin("stdlib"))
    implementation("org.apache.opennlp:opennlp-tools:2.3.3")
    implementation("com.github.pemistahl:lingua:1.2.2")
}