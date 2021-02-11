resource "aws_security_group" "sg_ssh_testing_2" {
  name        = "${var.project_name} sg_ssh_testing_1"
  description = "Grupo de seguridad para liberar ssh para el proyecto ${var.project_name}"

  ingress {
    description = "ssh"
    from_port   = 22
    to_port     = 22
    protocol    = "TCP"
    cidr_blocks = [
    "0.0.0.0/0"]
  }

  egress {
    from_port = 0
    to_port   = 0
    protocol  = "-1"
    cidr_blocks = [
    "0.0.0.0/0"]
  }

  tags = {
    ENV     = "DEV",
    GROUP   = "DEFAULT",
    VERSION = "1.0"
    PROJECT = var.project_name
  }
}

resource "aws_security_group" "sg_http_testing_2" {
  name        = "${var.project_name} sg_http_testing_1"
  description = "Grupo de seguridad para liberar http para el proyecto ${var.project_name}"

  ingress {
    description = "http"
    from_port   = var.port_default
    to_port     = var.port_default
    protocol    = "TCP"
    cidr_blocks = [
    "0.0.0.0/0"]
  }

  egress {
    from_port = 0
    to_port   = 0
    protocol  = "-1"
    cidr_blocks = [
    "0.0.0.0/0"]
  }

  tags = {
    ENV     = "DEV",
    GROUP   = "DEFAULT",
    VERSION = "1.0"
    PROJECT = var.project_name
  }
}