data "aws_vpc" "default" {
  default = true
}

data "aws_availability_zones" "all_available" {
  state = "available"
}

resource "aws_elb" "terraform_elb_testing_1" {
  name               = "proyecto-golang-personas-elb"
  availability_zones = data.aws_availability_zones.all_available.names

  listener {
    instance_port     = var.port_default
    instance_protocol = "http"
    lb_port           = var.port_default
    lb_protocol       = "http"
  }

  health_check {
    healthy_threshold   = 2
    unhealthy_threshold = 2
    timeout             = 3
    target              = "HTTP:${var.port_default}/"
    interval            = 30
  }

  instances = [
    aws_instance.instancia_testing_1.id
  ]
  cross_zone_load_balancing   = true
  idle_timeout                = 400
  connection_draining         = true
  connection_draining_timeout = 400

  tags = {
    ENV   = "DEV"
    GROUP = "DEFAULT"
    TYPE  = "TESTING"
    NAME  = var.project_name
  }
}