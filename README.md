# Gauge Java Maven Demo

这是一个使用Gauge框架的Java自动化测试示例项目，展示了如何使用Gauge和Maven进行API测试和Web UI测试。

## 功能特点

- 集成Gauge测试框架
- 支持API自动化测试
- 支持Web UI自动化测试
- 使用Maven管理项目依赖
- 支持Docker容器化运行
- 集成GitHub Actions自动化工作流

## 环境要求

- Java 8或更高版本
- Maven 3.6或更高版本
- Gauge
- Chrome浏览器（用于Web UI测试）
- Docker（可选，用于容器化运行）

## 安装步骤

1. 安装Gauge
```bash
# MacOS
brew install gauge

# Windows
choco install gauge
```

2. 克隆项目
```bash
git clone <repository-url>
cd gauge-java-maven-demo
```

3. 安装项目依赖
```bash
mvn clean install
```

## 运行测试

### 使用Maven运行
```bash
mvn test
```

### 使用Gauge命令运行
```bash
gauge run specs
```

### 使用Docker运行
```bash
# 构建Docker镜像
docker build -t gauge-java .

# 运行测试
docker run --rm -it -v ${PWD}/reports:/gauge/reports gauge-java
```

## 项目结构

```
├── specs/                 # Gauge规范文件
│   ├── api_test.spec      # API测试规范
│   └── web_login_test.spec # Web UI测试规范
├── src/
│   └── test/
│       └── java/         # 测试实现代码
├── env/                   # 环境配置
└── reports/              # 测试报告
```

## 测试报告

测试执行完成后，可以在`reports/html-report`目录下查看HTML格式的测试报告。

## 持续集成

项目已配置GitHub Actions工作流，每次推送代码时会自动运行测试。详细配置请查看`.github/workflows`目录。

## 贡献指南

1. Fork本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 创建Pull Request

## 许可证

本项目采用MIT许可证 - 查看[LICENSE](LICENSE)文件了解详情。