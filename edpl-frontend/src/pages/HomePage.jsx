import { Card, Row, Col } from 'antd';
import { Link } from 'react-router-dom';

const HomePage = () => {
  return (
    <div style={{ padding: '50px' }}>
      <Row gutter={[16, 16]}>
        <Col span={12}>
          <Link to="/courses">
            <Card
              hoverable
              style={{ borderRadius: '15px' }}
              cover={
                <img
                  alt="courses"
                  src="https://www.meme-arsenal.com/memes/7b13377f902b73504fa855577f13a24f.jpg"
                  style={{ borderRadius: '15px 15px 0 0' }}
                />
              }
            >
              <Card.Meta title="Курсы" />
            </Card>
          </Link>
        </Col>
        <Col span={12}>
          <Link to="/forum">
            <Card
              hoverable
              style={{ borderRadius: '15px' }}
              cover={
                <img
                  alt="forum"
                  src="https://www.meme-arsenal.com/memes/7b13377f902b73504fa855577f13a24f.jpg"
                  style={{ borderRadius: '15px 15px 0 0' }}
                />
              }
            >
              <Card.Meta title="Форум" />
            </Card>
          </Link>
        </Col>
      </Row>
    </div>
  );
};

export default HomePage;