import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    // jcenter, mavenCentral 둘다 플러그인 저장소로,
    // jcenter 에서는 mavenCentral 보다 더 쉽게 라이브러리를 업로드 할 수 있도록 보완하여
    // jcenter 를 많이 사용하는 추세로 간다고 한다.
    //jcenter()     // 뭐야 근데 Deprecated 되어 있네? (사유: 지원 종료)
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}