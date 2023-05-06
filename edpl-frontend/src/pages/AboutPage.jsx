import React from "react";
import { Layout, Typography } from "antd";
import { Content, Footer } from "antd/es/layout/layout";

const { Title, Paragraph } = Typography;

const AboutPage = () => {
    return (
        <>
            <Layout>
                <Content style={{ padding: '50px' }}>
                    <div style={{ maxWidth: 800, margin: "0 auto" }}>
                        <Title level={2}>Our Story</Title>
                        <Paragraph>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis auctor
                            ultrices lectus, vel molestie neque consectetur quis. Nulla id magna
                            sapien. Aliquam tincidunt velit vel nunc malesuada hendrerit. Vivamus
                            luctus, risus quis tristique fermentum, mauris ex accumsan libero, id
                            pellentesque turpis quam non enim. Nunc id odio pharetra, malesuada
                            justo eu, ultrices nisi. Etiam in blandit neque. Curabitur vehicula
                            magna quis tortor eleifend venenatis. Nulla facilisi. Nulla facilisi.
                            Aenean lacinia est sed sapien consequat, nec mollis nulla euismod.
                            Curabitur sit amet mi vitae mauris suscipit finibus. Fusce bibendum,
                            quam at sollicitudin aliquam, nunc libero fringilla nulla, id
                            ullamcorper ex nibh eget lorem.
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis auctor
                            ultrices lectus, vel molestie neque consectetur quis. Nulla id magna
                            sapien. Aliquam tincidunt velit vel nunc malesuada hendrerit. Vivamus
                            luctus, risus quis tristique fermentum, mauris ex accumsan libero, id
                            pellentesque turpis quam non enim. Nunc id odio pharetra, malesuada
                            justo eu, ultrices nisi. Etiam in blandit neque. Curabitur vehicula
                            magna quis tortor eleifend venenatis. Nulla facilisi. Nulla facilisi.
                            Aenean lacinia est sed sapien consequat, nec mollis nulla euismod.
                            Curabitur sit amet mi vitae mauris suscipit finibus. Fusce bibendum,
                            quam at sollicitudin aliquam, nunc libero fringilla nulla, id
                            ullamcorper ex nibh eget lorem.
                        </Paragraph>

                        <Title level={2}>Our Team</Title>
                        <Paragraph>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis auctor
                            ultrices lectus, vel molestie neque consectetur quis. Nulla id magna
                            sapien. Aliquam tincidunt velit vel nunc malesuada hendrerit. Vivamus
                            luctus, risus quis tristique fermentum, mauris ex accumsan libero, id
                            pellentesque turpis quam non enim. Nunc id odio pharetra, malesuada
                            justo eu, ultrices nisi. Etiam in blandit neque. Curabitur vehicula
                            magna quis tortor eleifend venenatis. Nulla facilisi. Nulla facilisi.
                            Aenean lacinia est sed sapien consequat, nec mollis nulla euismod.
                            Curabitur sit amet mi vitae mauris suscipit finibus. Fusce bibendum,
                            quam at sollicitudin aliquam, nunc libero fringilla nulla, id
                            ullamcorper ex nibh eget lorem.
                        </Paragraph>
                    </div>
                </Content>
                <Footer style={{ textAlign: 'center' }}>MyApp ©2023 Created by Me</Footer>
            </Layout>
        </>
    );
};

export default AboutPage;