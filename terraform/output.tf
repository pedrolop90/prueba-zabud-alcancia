output "instance_public_ip" {
  value = aws_instance.instancia_testing_1.public_ip
}

output "elb_dns_name" {
  value = aws_elb.terraform_elb_testing_1.dns_name
}
